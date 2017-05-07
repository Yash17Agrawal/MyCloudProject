/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author code_eagle
 */
@Entity
@Table(name = "loan_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanTable.findAll", query = "SELECT l FROM LoanTable l")
    , @NamedQuery(name = "LoanTable.findByLoanId", query = "SELECT l FROM LoanTable l WHERE l.loanId = :loanId")
    , @NamedQuery(name = "LoanTable.findByTransactionId", query = "SELECT l FROM LoanTable l WHERE l.transactionId = :transactionId")
    , @NamedQuery(name = "LoanTable.findByAccountId", query = "SELECT l FROM LoanTable l WHERE l.accountId = :accountId")
    , @NamedQuery(name = "LoanTable.findByRate", query = "SELECT l FROM LoanTable l WHERE l.rate = :rate")
    , @NamedQuery(name = "LoanTable.findByPrincipal", query = "SELECT l FROM LoanTable l WHERE l.principal = :principal")
    , @NamedQuery(name = "LoanTable.findByDuration", query = "SELECT l FROM LoanTable l WHERE l.duration = :duration")})
public class LoanTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "loan_id")
    private Integer loanId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transaction_id")
    private int transactionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_id")
    private int accountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private double rate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "principal")
    private double principal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private double duration;

    public LoanTable() {
    }

    public LoanTable(Integer loanId) {
        this.loanId = loanId;
    }

    public LoanTable(Integer loanId, int transactionId, int accountId, double rate, double principal, double duration) {
        this.loanId = loanId;
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.rate = rate;
        this.principal = principal;
        this.duration = duration;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanId != null ? loanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanTable)) {
            return false;
        }
        LoanTable other = (LoanTable) object;
        if ((this.loanId == null && other.loanId != null) || (this.loanId != null && !this.loanId.equals(other.loanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.LoanTable[ loanId=" + loanId + " ]";
    }
    
}
