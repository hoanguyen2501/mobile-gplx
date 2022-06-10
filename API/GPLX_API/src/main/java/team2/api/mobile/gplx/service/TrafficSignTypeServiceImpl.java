package team2.api.mobile.gplx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.models.TrafficSign;
import team2.api.mobile.gplx.models.TrafficSignType;
import team2.api.mobile.gplx.repository.TrafficSignTypeRepository;
import team2.api.mobile.gplx.service.interfaces.TrafficSignTypeService;

@Service
public class TrafficSignTypeServiceImpl extends GenericServiceImpl<TrafficSignType, String> implements TrafficSignTypeService {

	@Autowired
	private TrafficSignTypeRepository repo;
	
	@Override
	public TrafficSignType findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public TrafficSignType update(TrafficSignType trafficSignType, String id) {
		try {
			TrafficSignType updatedTrafficSignType = repo.findById(id).get();
			updatedTrafficSignType.setCode(trafficSignType.getCode());
			updatedTrafficSignType.setName(trafficSignType.getName());
			return repo.save(updatedTrafficSignType);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public TrafficSignType findByCode(String code) {
		return repo.findByCode(code);
	}
	
	@Override
	public TrafficSignType findTrafficSignTypeById(String id) {
		try {
			TrafficSignType object = repo.findById(id).get();
			return object;
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
