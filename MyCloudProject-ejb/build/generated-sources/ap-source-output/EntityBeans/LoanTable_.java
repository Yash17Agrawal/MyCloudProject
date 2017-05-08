package EntityBeans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T19:51:53")
@StaticMetamodel(LoanTable.class)
public class LoanTable_ { 

    public static volatile SingularAttribute<LoanTable, Double> principal;
    public static volatile SingularAttribute<LoanTable, Double> duration;
    public static volatile SingularAttribute<LoanTable, Integer> accountId;
    public static volatile SingularAttribute<LoanTable, Double> rate;
    public static volatile SingularAttribute<LoanTable, Integer> loanId;
    public static volatile SingularAttribute<LoanTable, Integer> transactionId;

}