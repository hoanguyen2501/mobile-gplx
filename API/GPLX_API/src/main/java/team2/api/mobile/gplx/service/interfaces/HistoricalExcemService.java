package team2.api.mobile.gplx.service.interfaces;

import java.util.List;

import team2.api.mobile.gplx.commondata.GenericService;
import team2.api.mobile.gplx.models.HistoricalExam;

public interface HistoricalExcemService extends GenericService<HistoricalExam, String> {
	List<HistoricalExam> findByUserId(String userid);
}

