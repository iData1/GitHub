/**
 * @author Samuel Dias da Silva
 * data: 17.04.2015
 * 
 */
public class calcolatrice{
	public static void calcolatrice(String[] args){
		double sum = 0, num = 0, division = 0,sumDivision = 0, multiplication = 0, sumMultiplication = 0;
		byte counter = 0;
		boolean sumVer = false;
		/**
		 *  Parte per la divisione 
		 */
		for(int count = 0; count < args.length; count++){
			try{
				num = Double.parseDouble(args[count]);
			}
			catch(NumberFormatException e){
			}
			if(counter==0){
				if(args[count].equals("/")){
					try{
						division = Double.parseDouble(args[count-1])/Double.parseDouble(args[count+1]);
						sumDivision+=division;
						counter++;
					}
  				catch(NumberFormatException e){
  					System.out.println("errore");
  					
  				}
				}
			}
			else if(counter>0){
			  if(args[count].equals("/")){
					try{
						division = sumDivision/Double.parseDouble(args[count+1]);
						sumDivision=division;
					}
  				catch(NumberFormatException e){
  					System.out.println("errore");
  				}
			  }
  		}
		}
		System.out.println("Divisione: "+sumDivision);
		/**
		 *  Parte per la moltiplicazione 
		 */		
		for(int count = 0; count < args.length; count++){
			try{
				num = Double.parseDouble(args[count]);
			}
			catch(NumberFormatException e){
			}
			if(counter==0){
				if(args[count].equals("*")){
					try{
						multiplication = Double.parseDouble(args[count-1])*Double.parseDouble(args[count+1]);
						sumMultiplication+=multiplication;
						counter++;
					}
  				catch(NumberFormatException e){
  					System.out.println("errore");
  					
  				}
				}
			}
			else if(counter>0){
			  if(args[count].equals("*")){
					try{
						multiplication = sumMultiplication*Double.parseDouble(args[count+1]);
						sumMultiplication=multiplication;
					}
  				catch(NumberFormatException e){
  					System.out.println("errore");
  				}
			  }
  		}
		}
		System.out.println("Moltiplicazione: "+sumMultiplication);
		
		
		/**
		 * Parte per la somma
		 */
		for(int count = 0; count < args.length; count++){
			try{
				num = Double.parseDouble(args[count]);
				sumVer=false;
			}
			catch(NumberFormatException e){
        if(!(args[count]=="+"||args[count]=="-"||args[count]=="*"||args[count]=="/")){
          sumVer=true;
        }
			}
			if(!(count==0)){
				if(args[count-1].equals("+") && sumVer==false){
					sum+=num;
				}
				else if(args[count-1].equals("-")&& sumVer==false){
					sum-=num;
				}
			}
		}
		sum+=sumDivision+sumMultiplication;
		System.out.println("Somma: "+sum);
	}
	
	
	public static void main(String[] args){
		calcolatrice(args);
	}
}