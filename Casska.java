/**
 * Próba podłączenia się do Cassandry i wykonanie prostych instrukcji na bazie.
 * Wszystkie zewnętrzne biblioteki dodałem ręcznie, plik po pliku. 
 */

package slawissimo;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * @author wentilo  kk
 *
 */
public class Casska {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createKeyspace();

			}
	
		public static void createKeyspace()
		{
			Cluster cluster = Cluster.builder()
	                 .addContactPoints("127.0.0.1")
	                 .build();
			Session session = cluster.connect();
			String cqlStatement = "CREATE KEYSPACE testy1 WITH " + 
			                     "replication = {'class':'SimpleStrategy','replication_factor':1}";        
			session.execute(cqlStatement);
			
			String cqlStatement2 = "CREATE TABLE testy1.users (" + 
			                      " user_name varchar PRIMARY KEY," + 
			                      " password varchar " + 
			                      ");";
			session.execute(cqlStatement2);
			
			System.out.println("Done");
			System.exit(0);
			
			}
}

