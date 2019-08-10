package com.qf.service.impl;

import com.qf.enums.Status;
import com.qf.mapper.BorrowMapper;
import com.qf.pojo.Borrow;
import com.qf.common.Product;
import com.qf.service.BorrowMapperService;
import com.qf.vo.HistoryVO;
import com.qf.vo.PayVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生活很好，记得微笑🙂
 */
@Service
public class BorrowMapperServiceImpl implements BorrowMapperService {

    @Resource
    private BorrowMapper borrowMapper;


    @Override
    public List<Borrow> findallborrow() {
        return borrowMapper.findallborrow();
    }


    @Override
    @Transactional
    public int repayment(int bid) {

        Borrow borrow = borrowMapper.selectByPrimaryKey(bid);
        borrow.setPayNumber(borrow.getPayNumber()+1);
        //调用mapper层方法
        int i = borrowMapper.updateByPrimaryKeySelective(borrow);
        return i;
    }

    @Override
    public Borrow selectByPrimaryKey(Integer bid) {
        return borrowMapper.selectByPrimaryKey(bid);
    }

    @Override
    public HistoryVO findByStatus(int uid, int status) {

        HistoryVO historyVO = new HistoryVO();
        List<Borrow> borrows = borrowMapper.findByStatus(uid, status);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        for (Borrow borrow : borrows) {
            //复制属性值
            historyVO.setPid(borrow.getPid());
            historyVO.setPayNumber(borrow.getPayNumber());
            historyVO.setBmoney(borrow.getBmoney());
            historyVO.setTotalNumber(borrow.getTotleNumber());
            historyVO.setBdate(simpleDateFormat.format(borrow.getBdate()));
            historyVO.setAppTime(simpleDateFormat.format(borrow.getAppTime()));
            historyVO.setStatus(borrow.getStatus());
            //本息
            double money = borrow.getBmoney() * Math.pow(borrow.getTotleNumber(), Product.monrate);
            historyVO.setTotalMoney(money);
            List<PayVO> list = new ArrayList<>();
            //如果是还款中或已还清，展示
            if (status== Status.PAYING.getCode()||status==Status.PAID.getCode()){
                //已还期数
                Integer payNumber = borrow.getPayNumber();
                if (payNumber>0&&payNumber<=borrow.getTotleNumber()) {
                    for (Integer i = 1; i <= payNumber; i++) {
                        PayVO payVO = new PayVO();
                        payVO.setPay(money / (borrow.getTotleNumber()));
                        payVO.setPeriod(i);
                        payVO.setRest(money - (money/(borrow.getTotleNumber()))*i);
                        Date bdate = borrow.getBdate();
                        bdate.setMonth(bdate.getMonth()+i);
                        payVO.setLast_date(simpleDateFormat.format(bdate));
                        list.add(payVO);
                    }
                }
                historyVO.setDetails(list);
            }else {
                historyVO.setDetails(null);
            }
        }
        return historyVO;
    }
     @Override
    public List<Borrow> selectBorrow() {
        return borrowMapper.selectBorrow();
    }

    @Override
    public List<Borrow> selectSchedule(String uid) {
        return borrowMapper.selectSchedule(uid);
    }
    @Override
    @Transactional
    public int insertSelective(Borrow record) {
        return borrowMapper.insertSelective(record);
    }
}
