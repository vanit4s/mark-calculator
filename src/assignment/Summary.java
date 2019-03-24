import java.util.Scanner;

public class Summary {
	
	public static int[][] userInput() {
		Scanner s = new Scanner(System.in);
		int[][] moduleMarks = new int[6][3];
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("Module %d:%n", i + 1);
			System.out.print("Weighting: ");
			moduleMarks[i][0] = Integer.parseInt(s.nextLine());
			System.out.print("Coursework mark: ");
			moduleMarks[i][1] = Integer.parseInt(s.nextLine());
			System.out.print("Exam mark: ");
			moduleMarks[i][2] = Integer.parseInt(s.nextLine());
			
			System.out.println();
		}
		
		s.close();
		return moduleMarks;
	}

	public static void main(String[] args) {
		StudentChart graph = new StudentChart(data);
		
		int[][] data = userInput();
		int[] moduleMarks = MarkCalculator.computeMarks(data); 
		
		graph.Draw(moduleMarks);
	}
	
}
