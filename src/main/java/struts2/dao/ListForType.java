package struts2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class ListForType<P extends DaoBase<P>, C extends DaoBase<C>> {

	public P listForDaoType(Connection conn, Class<P> parent, Class<C> child) throws SQLException, InstantiationException, IllegalAccessException {
		P iParent = parent.newInstance();
		// throwaway instance for query building.
		C iChild = child.newInstance();
	    // Create a Statement
        PreparedStatement ps = 
        		conn.prepareStatement ("select t.* from " + iChild.getTable() + " t where t."+getJoinColumn()+" = ?");
        ps.setLong(1, getParentId());
	    ResultSet rset = ps.executeQuery();
	    // Select first_name and last_name column from the customers table
	    try {
	    	while ( rset.next() ) {
	    		iChild = child.newInstance();
	    		iChild.decodeResultSet(rset);
	    		getCollection(iParent).add(iChild);
	    	}
	    	for ( C tChild: getCollection(iParent)) {
	    		tChild.fetchEagerDependencies(conn);
	    	}
		    return iParent;
	    } finally {
		    // Close the RseultSet
		    rset.close();
	    }
	}

	public abstract Long getParentId();
	public abstract String getJoinColumn();
	public abstract List<C> getCollection(P parent);
}
