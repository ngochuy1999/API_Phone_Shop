package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.Account;
import com.ngochuy.apiphoneshop.entities.Customer;
import com.ngochuy.apiphoneshop.entities.Role;
import com.ngochuy.apiphoneshop.payload.LoginResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AccountDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public Customer getUser(int userId){
        Session session = sessionFactory.getCurrentSession();
        Customer user =(Customer) session.createQuery("FROM Customer c WHERE c.userId = '"+userId+"'").uniqueResult();
        return user;
    }

    public List<Account> getAllAccounts(){
        Session session = sessionFactory.getCurrentSession();
        List<Account> listAccounts =(List<Account>) session.createQuery("from "+Account.class.getName()).list();
        System.out.println(listAccounts);
        return listAccounts;
    }

    public LoginResponse findByEmail(String email){
            Session session = sessionFactory.getCurrentSession();
            Account account =(Account) session.createQuery("FROM Account p WHERE p.email = '"+email+"'").uniqueResult();

            Customer user =(Customer) session.createQuery("FROM Customer c WHERE c.account.accountId = '"+account.getAccountId()+"'").uniqueResult();
            LoginResponse loginResponse = new LoginResponse();

            if(account!= null) {
                loginResponse.setEmail(account.getEmail());
                loginResponse.setPassword(account.getPassword());
                loginResponse.setId(user.getUserId());
                return loginResponse;
            }
            else
            return new LoginResponse("null","null",0);
    }

    public Boolean createUser(String email, String name, String password, String phone, String address) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Role role = (Role) session.createQuery("FROM Role as r WHERE r.roleId=1").uniqueResult();
            Account account = new Account();
            account.setRole(role);
            account.setEmail(email);
            account.setPassword(password);
            account.setUserName(name);
            account.setActive(1);
            session.save(account);

            Customer customer = new Customer();
            customer.setAccount(account);
            customer.setName(name);
            customer.setPhone(phone);
            customer.setAddress(address);
            long millis=System.currentTimeMillis();   java.sql.Date date=new java.sql.Date(millis);
            customer.setDateCreate(date);
            session.save(customer);

            t.commit();
            return true;
        } catch (Exception e) {
            t.rollback();
            System.out.println("Loi" + e);
        } finally {
            session.close();
        }
        return false;
    }

    public boolean updateUser(int id, String name, String phone, String address) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            String hql = "UPDATE Customer set name = :name ,phone = :phone,address =:address"  +
                    " WHERE userId = :id";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("phone", phone);
            query.setParameter("address", address);
            query.setParameter("id",id);
            int result = query.executeUpdate();
            t.commit();
            if(result==1) return true;
            else return false;
        } catch (Exception e) {
            t.rollback();
            System.out.println(e);
        } finally {
            session.close();
        }
        return false;
    }
    public boolean changePassword(int id, String oldPassword, String newPassword) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Customer customer = getUser(id);
            int accId = customer.getAccount().getAccountId();
            if(oldPassword.equals(customer.getAccount().getPassword())){
                String hql = "UPDATE Account set password = :password "  +
                        " WHERE accountId = :accId";
                Query query = session.createQuery(hql);
                query.setParameter("password", newPassword);
                query.setParameter("accId",accId);
                int result = query.executeUpdate();
                t.commit();
                if(result == 1) return true;
                else return false;
            }else return false;
        } catch (Exception e) {
            t.rollback();
            System.out.println("Loi" + e);
        } finally {
            session.close();
        }
        return false;
    }

}
