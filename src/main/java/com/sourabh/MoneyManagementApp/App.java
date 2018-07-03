package com.sourabh.MoneyManagementApp;

import com.sourabh.Service.RetriveOprations;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String ,Double> contri = new HashMap<>();
		String contributer = null;
		Double contribution;
		while(!"done".equals(contributer)){
			System.out.println("Enter the name of the contributer or Enter done if you are done");
			 contributer = sc.next();
			 if(contributer.equals("done")){break;}
			 System.out.println("Enter the amount contributed");
			 contribution =sc.nextDouble();
			 contri.put(contributer, contribution);
		}
		System.out.println("Money Contributed:-->"+contri);
		System.out.println("Individual payable amount--->"+ indidualAmountPayable(contri));
		System.out.println("Individual Banlance--->"+ individualBalance(contri,indidualAmountPayable(contri)));
	}
	private static double indidualAmountPayable(Map<String, Double> contri){
		double value = 0.0;
		for (Entry<String, Double> entry : contri.entrySet()){
             value +=  entry.getValue();
            }
		System.out.println(value+"/"+contri.size());
		return value/contri.size();
		}
	private static Map individualBalance(Map<String, Double > m, double value){
		for (Map.Entry<String,Double> entry : m.entrySet()){
             entry.setValue(value - entry.getValue());
             }
		return m;
}
        
    }
}
