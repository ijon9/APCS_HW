public class StatsDriver {

	public static void main(String[] args) { //Main method for testing

		System.out.println(Stats.mean(6, 10)); //expecting 8
		System.out.println(Stats.mean(3.6, 4.8)); //expecting 4.2
		System.out.println(Stats.max(10, 6)); //expecting 10
		System.out.println(Stats.max(19.5, 38.9)); //expecting 38.9
		System.out.println(Stats.geoMean(2, 18)); // expecting 6
		System.out.println(Stats.geoMean(5.5, 93.7)); //expecting 22.70132...
		System.out.println(Stats.max(12, 39, 34)); //expecting 39
		System.out.println(Stats.max(1.1, 2.3, 5.3)); // expecting 5.3
		System.out.println(Stats.geoMean(2, 8, 4)); //expecting 8
		System.out.println(Stats.geoMean(2.4, 5.6, 3.6)); //expecting 6.955...
	}

}