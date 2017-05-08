package EntityBeans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T19:51:53")
@StaticMetamodel(Accounts.class)
public class Accounts_ { 

    public static volatile SingularAttribute<Accounts, Integer> accountId;
    public static volatile SingularAttribute<Accounts, Double> amount;
    public static volatile SingularAttribute<Accounts, Integer> pin;
    public static volatile SingularAttribute<Accounts, String> accountType;
    public static volatile SingularAttribute<Accounts, Integer> userId;
    public static volatile SingularAttribute<Accounts, Integer> loanId;

}