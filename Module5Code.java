interface Domestic { }
interface Import { }
interface Japanese extends Import { }
interface German extends Import { }
interface Detroit extends Domestic { }
interface SpringHill extends Domestic { }
   
interface Vehicle {int getWeightInPounds( ); }
interface Automobile extends Vehicle { }
interface LargeAutomobile extends Vehicle { }
interface Sedan extends Automobile { }
interface Van extends LargeAutomobile { }
interface Truck extends LargeAutomobile { }
interface Compact extends Automobile { }
interface SportsUtilityVehicle extends Truck, Van { }

class SmallCar implements Automobile {
	public int getWeightInPounds( ) {
		return 1000;
	}	
}

class LargeTruck implements LargeAutomobile {
	public int getWeightInPounds( ) {
		return 2500;
	}
}

class SaturnSL1 extends SmallCar implements SpringHill, Sedan { }
class HondaCivic extends SmallCar implements Japanese, Compact { }
class MercedesC230 extends SmallCar implements German, Sedan { }
class ChevyS10 extends LargeTruck implements Detroit, Truck { }
class SubaruOutback extends LargeTruck implements Japanese, SportsUtilityVehicle { }

public class Module5Code {
	public static void main(String[] args) {
		
		SaturnSL1 sl = new SaturnSL1( );
		HondaCivic hc = new HondaCivic( );
		Japanese jp = null;
		German gr = new MercedesC230( );
		ChevyS10 cs = null;
		SubaruOutback sb = new SubaruOutback( );
		Domestic dm = sl;
		//dm = hc;
		//dm = (Domestic) hc;			
		dm = cs;			
		dm = (Domestic) cs;			
		Import im = sb;			
		//gr = im;			
		//gr = (German) im;			
		//jp = im;			
		//jp = (German) im;			
		jp = (Japanese) im;			
		Automobile a = null;			
		a = hc;
	
	}
}
