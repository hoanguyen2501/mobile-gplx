package team2.api.mobile.gplx.service.interfaces;

import java.util.List;

import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.TrafficSign;

public interface TrafficSignService extends GenericService<TrafficSign, String> {
	TrafficSign findByTrafficSignTypeId(String id);
	TrafficSign update(TrafficSign trafficSign, String id);
	List<TrafficSign> findByTrafficSignType(String id);
}