package eu.phiwa.dt;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;

import eu.phiwa.dt.flights.Waypoint;

public class Flight {

	public String name;
	public String displayname;
	public World world;
	public List<Waypoint> waypoints = new ArrayList<Waypoint>();
	public int wpcount = 0;
	
	public Flight() {
		
	}
	
	public Flight(World world, String flightname) {		
		this.displayname = flightname;
		this.name = flightname.toLowerCase();
		this.world = world;
	}

	public String toString() {

		String flightString = displayname + ":\n";
		
		for(Waypoint wp: waypoints) {
			flightString += "- " + wp.x + ", " + wp.y + ", " + wp.z + "\n";
		}
		
		return flightString;		
	}
	
	public void addWaypoint(Waypoint wp) {
		waypoints.add(wp);
		wpcount++;
	}
	
	public void removelastWaypoint() {
		
		// Remove marker from waypoint
		waypoints.get(waypoints.size()-1).removeMarker();
		
		waypoints.remove(waypoints.size()-1);
		wpcount--;
	}

}
