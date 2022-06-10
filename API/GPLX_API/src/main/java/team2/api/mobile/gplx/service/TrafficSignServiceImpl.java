package team2.api.mobile.gplx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.models.TrafficSign;
import team2.api.mobile.gplx.repository.TrafficSignRepository;
import team2.api.mobile.gplx.service.interfaces.TrafficSignService;

@Service
public class TrafficSignServiceImpl extends GenericServiceImpl<TrafficSign, String> implements TrafficSignService {

	@Autowired
	private TrafficSignRepository repo;
	
	@Override
	public TrafficSign update(TrafficSign trafficSign , String id) {
		try {
			TrafficSign updatedTrafficSign = repo.findById(id).get();
			updatedTrafficSign.setCode(trafficSign.getCode());
			updatedTrafficSign.setName(trafficSign.getName());
			updatedTrafficSign.setDescription(trafficSign.getDescription());
			updatedTrafficSign.setPhoto(trafficSign.getPhoto());
			updatedTrafficSign.setTrafficSignType(trafficSign.getTrafficSignType());
			return repo.save(updatedTrafficSign);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public TrafficSign findByTrafficSignTypeId(String id) {
		try {
			TrafficSign object = repo.findById(id).get();
			return object;
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<TrafficSign> findByTrafficSignType(String id) {
		try {
			return repo.findByTrafficSignType(id);
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}
}