package ftmk.rmi.sensor;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface represents temperature sensor
 * 
 * @author emalianakasmuri
 *
 */
public interface TemperatureSensor extends Remote {
	
	/**
	 * This method gets current temperature
	 * 
	 * @return current temperature
	 * 
	 * @throws RemoteException
	 */
	public int getTemperature() throws RemoteException;
	
	
	/**
	 * This method will accept specific day as key to get the temperature of that day
	 * 
	 * @return current temperature
	 * 
	 * @param day name
	 */
	public int getTemperatureByDay(String day)throws RemoteException;
	
	public float getAverageTemperature() throws RemoteException;
	

}