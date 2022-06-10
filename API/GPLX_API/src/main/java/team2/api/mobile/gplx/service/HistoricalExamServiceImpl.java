package team2.api.mobile.gplx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.api.mobile.gplx.commondata.GenericServiceImpl;
import team2.api.mobile.gplx.models.HistoricalExam;
import team2.api.mobile.gplx.repository.HistoricalExamRepository;
import team2.api.mobile.gplx.service.interfaces.HistoricalExcemService;

@Service
public class HistoricalExamServiceImpl extends GenericServiceImpl<HistoricalExam, String>
		implements HistoricalExcemService {

	@Autowired
	private HistoricalExamRepository repo;

	@Override
	public List<HistoricalExam> findByUserId(String userid) {
		try {
			return repo.findByUserId(userid);
		} catch (Exception e) {
			return null;
		}
	}

}