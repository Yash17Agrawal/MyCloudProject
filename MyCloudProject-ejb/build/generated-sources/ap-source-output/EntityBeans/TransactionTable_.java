package EntityBeans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T19:51:53")
@StaticMetamodel(TransactionTable.class)
public class TransactionTable_ { 

    public static volatile SingularAttribute<TransactionTable, Integer> userIdFrom;
    public static volatile SingularAttribute<TransactionTable, Date> dateTime;
    public static volatile SingularAttribute<TransactionTable, Double> amount;
    public static volatile SingularAttribute<TransactionTable, String> paymentMode;
    public static volatile SingularAttribute<TransactionTable, String> currentStatus;
    public static volatile SingularAttribute<TransactionTable, Integer> userIdTo;
    public static volatile SingularAttribute<TransactionTable, Integer> transactionId;

}