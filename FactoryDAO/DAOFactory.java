package com.ds.salesforce.dao.comp;

import java.util.List;

import com.ds.salesforce.dao.ISFBaseDAO;
import com.sforce.soap.enterprise.sobject.SObject;
import com.util.SFoAuthHandle;

public class DAOFactory implements ISFBaseDAO {

	// use getShape method to get object of type shape
	public static ISFBaseDAO getDAO(String DaoType) {
		if (DaoType == null) {
			return null;
		}
		if (DaoType.equalsIgnoreCase("Environment")) {
			return new EnvironmentDAO();
		} else if (DaoType.equalsIgnoreCase("DeployDetails")) {
			return new DeployDetailsDAO();
		} else if (DaoType.equalsIgnoreCase("DeploySettings")) {
			return new DeploySettingsDAO();
		} else if (DaoType.equalsIgnoreCase("MetadataDescription")) {
			return new MetadataDescriptionDAO();
		} else if (DaoType.equalsIgnoreCase("Package")) {
			return new PackageDAO();
		} else if (DaoType.equalsIgnoreCase("ReleasePackage")) {
			return new ReleasePackageDAO();
		} else if (DaoType.equalsIgnoreCase("MetadataLog")) {
			return new MetadataLogDAO();
		}
		return null;
	}

	@Override
	public List<Object> listAll(SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Object obj, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean commit(SObject[] sobjects, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object obj, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> findById(String orgId, SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return null;
	}

}