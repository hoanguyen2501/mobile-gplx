package team2.api.mobile.gplx.service.interfaces;

import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.TrafficSign;
import team2.api.mobile.gplx.models.TrafficSignType;

public interface TrafficSignTypeService extends GenericService<TrafficSignType, String> {
	TrafficSignType findByName(String name);
	
	TrafficSignType findByCode(String code);
	
	TrafficSignType findTrafficSignTypeById(String id);

	TrafficSignType update(TrafficSignType trafficSignType, String id);
	
}
