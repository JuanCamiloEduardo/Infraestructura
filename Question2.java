package Concurrencia;

public class Question2  extends Thread{
	private static int count1 =0 ;
	private static int count2 =0 ;
	private int id;
	private int currentIt;
	
	Question2(int id){
		this.id = id;
		this.currentIt=0;
		
	}
	
	private void runCounts() {
		System.out.println("");
		String msgEnd ="Thread %d - Fin Iteracion %d - Contador 1: %d - Contador 2 : %d";
		synchronized (Question2.class)
		{
			count1 += 100;
			count2 += 1000;
		}
		System.out.println(String.format(msgEnd, this.id,this.currentIt,count1,count2));
		System.out.println("");
	}
	@Override
	public void run()
	{
		for (int i=0; i< 3;i++ )
		{
			runCounts();
			this.currentIt++;
		}
	}
	public static void main(String[] args ) throws Exception{
		int nThreads= 3;
		Question2[] qThreads= new Question2[nThreads];
		for( int i=0; i<nThreads; i++) {
			qThreads[i]= new Question2(i);
		}
		for ( int i=0; i<nThreads; i++) {
			qThreads[i].start();
		}
	}
}
