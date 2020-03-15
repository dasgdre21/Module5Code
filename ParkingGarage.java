public class ParkingGarage {
	
	//fields
	private int totalVehicles;
	private int totalWeight;
	private Vehicle[] parkingSpots;
	
	//constructor
	public ParkingGarage() {
		this.totalVehicles = 0;
		this.totalWeight = 0;
		this.parkingSpots = new Vehicle[20];
	}
	
	//accessors
	public int getTotalVehicles() {
		return this.totalVehicles;
	}
	
	public int getTotalWeight() {
		return this.totalWeight;
	}
	
	//determines whether the garage can add another vehicle
	private boolean isFull(int addedWeight) {
		
		if ((this.totalVehicles + 1 <= 20) && (this.totalWeight + addedWeight <= 25000)) {
			
			return false;
		}
		
		return true; //garage is full
	}
	
	//finds the location of specified vehicle
	private int parkingSpot(Vehicle v) {
		
		for (int i = 0; i < parkingSpots.length; i++) {
			if (parkingSpots[i] == v) {
				return i;
			}
		}
		
		return -1; //vehicle is not in garage
	}
	
	//finds first empty parking spot in garage
	private int emptySpot() { 
		
		//traverses array to find first empty spot
		for (int i = 0; i < parkingSpots.length; i++) {
			if (parkingSpots[i] == null) {
				return i;
			}
		}
		
		return -1; //garage is full
	}
	
	public boolean addVehicle(Vehicle v) {						
		
		//adds vehicle if it doesn't exceed garage capacity
		if (!this.isFull(v.getWeightInPounds())) {
			
			this.totalVehicles++;
			this.totalWeight += v.getWeightInPounds();
			parkingSpots[this.emptySpot()] = v; //parks in next empty spot
			 
			return true; //vehicle successfully added
		}
		
		return false; //vehicle could not be added
	}
	
	public boolean removeVehicle(Vehicle v) {
		
		int spot = this.parkingSpot(v); //finds where vehicle is parked
		
		if (spot == -1) {			
			return false; //vehicle is not in garage, could not be removed		
		}
			
		this.totalVehicles--;
		this.totalWeight -= v.getWeightInPounds();
		parkingSpots[spot] = null; //removes vehicle from garage
		
		return true; //vehicle successfully removed
	}
	
	//static method that helps main method add vehicles
	public static void addVehicle(ParkingGarage g, Vehicle v) {
		if (g.addVehicle(v)) {
			System.out.println("Vehicle added.");
			System.out.println("Total vehicles: " + g.getTotalVehicles());
			System.out.println("Total weight: " + g.getTotalWeight());
			System.out.println();
		}
		else {
			System.out.println("Vehicle not added.");
			System.out.println();
		}
				
	}
	
	//static method that helps main remove vehicles
	public static void removeVehicle(ParkingGarage g, Vehicle v) {
		if (g.removeVehicle(v)) {
			System.out.println("Vehicle removed.");
			System.out.println("Total vehicles: " + g.getTotalVehicles());
			System.out.println("Total weight: " + g.getTotalWeight());
			System.out.println();
		}
		else {
			System.out.println("Vehicle not removed.");
			System.out.println();
		}		
	}
	
	public static void main(String[] args) {
	
		ParkingGarage garageOne = new ParkingGarage(); //creates a parking garage
		
		//creates 5 unique cars to add		
		SaturnSL1 a = new SaturnSL1();
		HondaCivic b = new HondaCivic();
		MercedesC230 c = new MercedesC230( );
		ChevyS10 d = new ChevyS10();
		SubaruOutback e = new SubaruOutback( );
		
		addVehicle(garageOne, a);
		addVehicle(garageOne, b);
		addVehicle(garageOne, c);
		addVehicle(garageOne, d);
		addVehicle(garageOne, e);

		
		for (int i = 0; i < 16; i++) { //last vehicle won't be added
			addVehicle(garageOne, a);	
		}
		
		removeVehicle(garageOne, a);
		removeVehicle(garageOne, b);
		removeVehicle(garageOne, c);
		removeVehicle(garageOne, d);
		removeVehicle(garageOne, e);
		
		for (int i = 0; i < 16; i++) { //last vehicle won't be removed
			removeVehicle(garageOne, a);	
		}
		
		SubaruOutback z = new SubaruOutback( ); //not in garage, won't be removed
		removeVehicle(garageOne, z);	
		
	}

}
