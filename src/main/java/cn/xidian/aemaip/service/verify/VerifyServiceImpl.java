package cn.xidian.aemaip.service.verify;

import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.stereotype.Service;

import cn.xidian.aemaip.entity.Company;
import cn.xidian.aemaip.entity.Users;
import cn.xidian.aemaip.service.CompanyService;
import cn.xidian.aemaip.service.UsersService;

@Service
public class VerifyServiceImpl implements VerifyService {
    
    @Resource
    CompanyService cs;
    
    @Resource
    UsersService us;
    
    public int verifyCompany(int id) throws Exception {
        cs.updateStateByID(id, 1);// 公司状态1代表审核通过
        Company c = cs.selectByID(id);
        int[] cid = { 9 };
        us.verifyByID(c.getAccount());// 账号启用
        us.setUserCharacter(c.getAccount(), cid);
        // 0. 邮件参数
        Properties prop = new Properties();
        prop.put("mail.transport.protocol", "smtp"); // 指定协议
        prop.put("mail.smtp.host", "smtp.163.com"); // 主机 stmp.qq.com
        prop.put("mail.smtp.auth", "true"); // 用户密码认证
        
        // 1. 创建一个邮件的会话
        Session session = Session.getDefaultInstance(prop);
        // 2. 创建邮件体对象 (整封邮件对象)
        MimeMessage message = new MimeMessage(session);
        // 3. 设置邮件体参数:
        // 3.1 标题
        message.setSubject("建筑工程多主体交互平台帐号授权");
        // 3.2 邮件发送时间
        message.setSentDate(new Date());
        // 3.3 发件人
        message.setSender(new InternetAddress("18829212334@163.com"));
        // 3.4 接收人
        message.setRecipient(RecipientType.TO,
                             new InternetAddress(c.getEmail()));
        // 3.5内容
        // message.setText("你好，已经发送成功！ 正文...."); // 简单纯文本邮件
        // 邮件中含有超链接
        // message.setText("<a href='#'>百度</a>");
        Users u = us.getByID(c.getAccount());
        message.setContent(c.getCompanyname() + "，你好：<br/>"
                           + "你已经成功注册建筑工程多主体交互平台！<br/>"
                           + "您的用户名为："
                           + u.getUsername()
                           + "<br/>您的初始密码为："
                           + u.getUsername().hashCode(),
                           "text/html;charset=UTF-8");
        
        message.saveChanges(); // 保存邮件(可选)
        
        // 4. 发送
        Transport trans = session.getTransport();
        trans.connect("18829212334@163.com", "lxing823");
        // 发送邮件
        trans.sendMessage(message, message.getAllRecipients());
        trans.close();
        return 0;
    }
    
}
