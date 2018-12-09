public class ProducerConsumer{
	public static void main(String args[]) throws InterruptedException
	{
		ProducerConsumerMethodClass PCObj=new 						ProducerConsumerMethodClass();
		Thread producer=new Thread(new Runnable() {
			public void run()
			{
				try
				{
					PCObj.produce();
				}
				catch(InterruptedException e)
				{
					System.out.println("Exception : "+e.getMessage());
				}
			}
		});
		Thread consumer=new Thread(new Runnable(){
			public void run()
			{
				try
				{
					PCObj.consume();
				}
				catch(InterruptedException e)
				{
					System.out.println("Exception : "+e.getMessage());
				}
			}
		});
		producer.start();//start producer thread;
		consumer.start();//start consumer thread;
	
		producer.join();//producer must stop before consumer and main threads
		consumer.join();//consumer must stop before main thread
	}	
}
