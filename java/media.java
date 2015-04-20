public class media{
	public static void media(String[] args){
		double num = 0;
		int counter = 0;
		double somma = 0;
		double divisione = 0;
		for(int count = 0; count < args.length; count++){
			try{
				num = Double.parseDouble(args[count]);
				if(num <= 6 && num > 1){
					somma+=num;
					counter++;
				}
			}
			catch(NumberFormatException e){
				if(args[count].equalsIgnoreCase("MB")){
					somma+=6;
					counter++;
				}
				else if(args[count].equalsIgnoreCase("B")){ 
          somma+=5;
					counter++;
        }
        else if(args[count].equalsIgnoreCase("S")){
          somma+=4;
          counter++;
        }
        else if(args[count].equalsIgnoreCase("I")){
          somma+=3;
          counter++;
        }
        else if(args[count].equalsIgnoreCase("MI")){
					somma+=2;
          counter++;
        }	
			}
		}
		divisione = somma / counter;
		System.out.println("Media: "+divisione);
	}
	public static void main(String[] args){
		media(args);
	}

}
