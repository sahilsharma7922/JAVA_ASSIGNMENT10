import java.util.*;
import java.io.*;
class ProducerConsumerMethodClass
{
	List<Integer> buffer=new ArrayList<Integer>();//Buffer List to store data produced
	int size=5;//Size of the buffer list
	void produce() throws InterruptedException//Producer Function
	{
		int filled=0;//Intially the buffer is empty
		while(true)
		{
			synchronized(this)
			{
				while(buffer.size()==size)//If buffer is filled,wait to get it free
					wait();
				System.out.println("Producer produced : "+(filled%size));
				buffer.add(filled++);//add item to buffer list
				notify();//notify the consumer to remove it from wait state
				Thread.sleep(1000);//force producer thread to sleep for 					1000ms
				if(filled==size)
					break;
			}
		}
	}
	void consume( ) throws InterruptedException//Consumer function
	{
		int item;
		while(true)
		{
			synchronized(this)
			{
while(buffer.isEmpty()==true)//isEmpty() return true if   
					wait();		   //buffer.size()==0
				item=buffer.remove(0);//remove first element to consume
				System.out.println("Consumer consumed : "+item);
				notify();//Notify producer that buffer is freed
				Thread.sleep(1000);//Force consumer thread to sleep for 					1000ms
			}
		}
	}
	
}
