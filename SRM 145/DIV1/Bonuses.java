    /*
    TopCoder
    Single Round Match: 145
    Division: 1
    Level: 1
    Points: 250 Points
    Description: http://community.topcoder.com/stat?c=problem_statement&pm=1677&rd=4530 
    */
 
   public class Bonuses {

	public int[] getDivision(int[] points) {
		int[] bonuses = new int[points.length];
		boolean[] extraBonus = new boolean[points.length];
		int totalPoints = 0;
		for (int point : points) {
			totalPoints += point;
		}

		int bonusPctRemaining = 100;
		for (int i = 0; i < points.length; i++) {
			bonuses[i] = (points[i] * 100) / totalPoints;
			bonusPctRemaining -= bonuses[i];
		}

		while (bonusPctRemaining > 0) {
			int maxPoints = -1;
			int employee = -1;
			for (int i = 0; i < points.length; i++) {
				if ((!extraBonus[i]) && (points[i] > maxPoints)) {
					employee = i;
					maxPoints = points[i];
				}
			}
			extraBonus[employee] = true;
			bonuses[employee] += 1;
			bonusPctRemaining -= 1;
		}
		return bonuses;
	}
}
