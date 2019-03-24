public class MarkCalculator {
	private final int[][] studentMarks;
	
	
	public MarkCalculator() {
		this.studentMarks = studentMarks;
	}

	public int[] computeMarks() {

		/* Declare a variable for a module mark, and a total
		 * that will be placed inside of a 1D array, later to be returned.  */
		int computedModuleMark = 0;
		int[] totalModuleMarks = new int[6];
		
		int courseworkMark = 0;
		int courseworkWeighting = 0;
		int examMark = 0;
		
		for (int i = 0; i < studentMarks.length; i++) {
			courseworkMark = studentMarks[i][0];
			courseworkWeighting = studentMarks[i][1];
			examMark = studentMarks[i][2];
			
			computedModuleMark = ((courseworkMark * courseworkWeighting) + (examMark * (100 - courseworkWeighting))) / 100;
			
			if (examMark >= 35 && courseworkMark >= 35) {
				totalModuleMarks[i] = (int)computedModuleMark;
			} else if(examMark < 35 || courseworkMark < 35) {
				totalModuleMarks[i] = Math.min(35, computedModuleMark);
			}
		}
		
		return totalModuleMarks;
	}
	
	public String computeResult(int[] totalModuleMarks) {
		
		int modulePass = 0;
		int moduleCompensatableFail = 0;
		int moduleCompensatableFailTotal = 0;
		int moduleFail = 0;
		
		int stageTotal = 0;
		int stageAverage = 0;
		
		for (int mark : totalModuleMarks) {
			if (mark >= 40) {
				modulePass += 1;
			} else if (mark <= 40 && mark >= 35) {
				moduleCompensatableFail += 1;
				moduleCompensatableFailTotal += mark;
			} else {
				moduleFail += 1;
			}
			
			stageTotal += 1;
		}
		
		stageAverage = (stageTotal / totalModuleMarks.length);
		
		if (modulePass == 6) {
			return "Pass";
		} else if (stageAverage >= 40 && moduleCompensatableFail <= 2 && moduleCompensatableFailTotal <= 40) {
			return "Pass By Compensation";
		} else {
			return "Fail";
		}
	}
	
	public static void main(String[] args) {
		MarkCalculator mark = new MarkCalculator();
		/* Call the functions here directly through the object */
	}
	
}
