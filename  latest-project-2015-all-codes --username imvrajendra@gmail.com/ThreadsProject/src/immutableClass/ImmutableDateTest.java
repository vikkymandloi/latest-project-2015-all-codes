package immutableClass;

import java.util.Date;


final class ImmutableReminder{
    private final Date remindingDate;
  
    public ImmutableReminder (Date remindingDate) {
        if(this.remindingDate.compareTo(remindingDate) > 0 ){
            throw new IllegalArgumentException("Can not set reminder for past time: " + remindingDate);
        }
        this.remindingDate = new Date(remindingDate.getTime());
    }
  
    public Date getRemindingDate() {
        return (Date) remindingDate.clone();
    }
}

public class ImmutableDateTest {
	
	public static void main(String[] args) throws InterruptedException {
		ImmutableReminder it1 =  new ImmutableReminder(new Date());
		
		System.out.println(it1.getRemindingDate());
		System.out.println(it1.hashCode());
		Thread.sleep(5000);
		
		it1 = new ImmutableReminder(new Date());
		System.out.println(it1.getRemindingDate());
		System.out.println(it1.hashCode());
	}
}
