package mcmullin;
/**
 * PythagoreanTriple
 * @author Cole McMullin
 * 4/19/2017
 * prints all pythagorean Triples where 0 < a and b < 100
 */
public class PythagoreanTriple {

	public static void main(String[] args) {
		int cSQR = 0;
		for(int i = 1; i < 100; i++){
			for(int j = 1; j < 100; j++){
				cSQR = (int)(Math.pow(i, 2) + Math.pow(j, 2));
				if (perfectSquare(cSQR)){
					System.out.println(i + " " + j + " " + (int)Math.sqrt(cSQR));
				}
			}
		}
	}
	/**
	 * determines wether or not a number is a perfect square
	 * @param n a number
	 * @return wether or not that number is a perfect square
	 */
	public static boolean perfectSquare(int n){
		int x = (int)Math.sqrt(n);
		double check = Math.pow(x,2);
		if (check == n){
			return true;
		}
		return false;
	}

}
