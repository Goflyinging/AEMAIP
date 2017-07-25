package cn.xidian.aemaip.service.verify;

public interface VerifyService {
    
    /**
     * Description:[审核公司]<br>
     * 处理逻辑：[传入公司id，修改公司状态到审核通过]<br>
     * 适用场景：[公司审核通过后调用]<br>
     * 
     * @author:余思佳
     * @update: 2016年8月26日
     * @param id
     * @return
     */
    public int verifyCompany(int id) throws Exception;
}
