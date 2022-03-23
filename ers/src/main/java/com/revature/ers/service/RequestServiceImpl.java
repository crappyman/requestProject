package com.revature.ers.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io;
import org.springframework.stereotype.Service;

import com.revature.ers.dao.RequestDao;
import com.revature.ers.entity.RequestEntity;
import com.revature.ers.pojo.RequestPojo;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	RequestDao requestDao;

	public RequestServiceImpl() {
		// requestDao = new RequestDaoImpl();
	}

	@Override
	public List<RequestPojo> viewAllRequest() {

		List<RequestPojo> allRequestPojo = new ArrayList<RequestPojo>();
		List<RequestEntity> allRequestEntity = requestDao.findAll();
		for (RequestEntity requsetEntity : allRequestEntity) {
			// int reqId, int userId, int reqType, int reqAmount, String submitDate, String
			// approveDate,int manager, int reqStatus
			RequestPojo requsetPojo = new RequestPojo(requsetEntity.getReqId(), requsetEntity.getUserId(),
					requsetEntity.getReqType(), requsetEntity.getReqAmount(), requsetEntity.getSubmitDate().toString(),
					requsetEntity.getApproveDate(), requsetEntity.getManager(), requsetEntity.getReqStatus());
			allRequestPojo.add(requsetPojo);
		}
		return allRequestPojo;
	}

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) {
		// int reqId, int userId, int reqType, int reqAmount, String submitDate, String
		// approveDate, Integer manager, int reqStatus
		System.out.println(requestPojo);
		RequestEntity requestEntity = new RequestEntity(requestPojo.getReqId(), requestPojo.getUserId(),
				requestPojo.getReqType(), requestPojo.getReqAmount(), new Date(), requestPojo.getManager(),
				1);
		
		requestEntity = requestDao.saveAndFlush(requestEntity);
		requestPojo = new RequestPojo(requestEntity.getReqId(), requestEntity.getUserId(), requestEntity.getReqType(),
				requestEntity.getReqAmount(), requestEntity.getSubmitDate().toString(), requestEntity.getApproveDate(),
				requestEntity.getManager(), requestEntity.getReqStatus());
		return requestPojo;
	}

	@Override
	public List<RequestPojo> viewPendingRequest() {
		// return requestDao.viewPendingRequest();

		List<RequestEntity> allRequestEntity = requestDao.findByReqStatus(1);

		for (RequestEntity r : allRequestEntity) {
			System.out.println(r);
		}

		List<RequestPojo> allRequestPojo = new ArrayList<RequestPojo>();
		for (RequestEntity requestEntity : allRequestEntity) {

			RequestPojo requsetPojo = new RequestPojo(requestEntity.getReqId(), requestEntity.getUserId(),
					requestEntity.getReqType(), requestEntity.getReqAmount(), requestEntity.getSubmitDate().toString(),
					requestEntity.getApproveDate(), requestEntity.getManager(), requestEntity.getReqStatus());
			allRequestPojo.add(requsetPojo);
		}
		return allRequestPojo;
	}

	@Override
	public RequestPojo reviewRequest(int reqId, int status) {
		Optional<RequestEntity> optional = requestDao.findById(reqId);
		RequestPojo requsetPojo = null;
		RequestEntity requestEntity = new RequestEntity();
		if (optional.isPresent()) {
			requestEntity = optional.get();
			requestEntity.setReqStatus(status);
			requestEntity = requestDao.save(requestEntity);
			requsetPojo = new RequestPojo(requestEntity.getReqId(), requestEntity.getUserId(),
					requestEntity.getReqType(), requestEntity.getReqAmount(), requestEntity.getSubmitDate().toString(),
					requestEntity.getApproveDate(), requestEntity.getManager(), requestEntity.getReqStatus());
		}

		return requsetPojo;
	}

	@Override
	public List<RequestPojo> deleteRequest(int reqId) {
		try {
			requestDao.deleteById(reqId);
			return viewAllRequest();
		} catch (Exception E) {
			return viewAllRequest();
		}

	}

	@Override
	public RequestPojo fetchARequest(int reqId) {
		Optional<RequestEntity> optional = requestDao.findById(reqId);
		RequestPojo requsetPojo = null;
		RequestEntity requestEntity = new RequestEntity();
		if (optional.isPresent()) {
			requestEntity = optional.get();
			requsetPojo = new RequestPojo(requestEntity.getReqId(), requestEntity.getUserId(),
					requestEntity.getReqType(), requestEntity.getReqAmount(), requestEntity.getSubmitDate().toString(),
					requestEntity.getApproveDate(), requestEntity.getManager(), requestEntity.getReqStatus());
		}

		return requsetPojo;
	}

	@Override
	public List<RequestPojo> viewRequestsByStatus(int status) {
		List<RequestEntity> allRequestEntity = requestDao.findByReqStatus(status);

		for (RequestEntity r : allRequestEntity) {
			System.out.println(r);
		}

		List<RequestPojo> allRequestPojo = new ArrayList<RequestPojo>();
		for (RequestEntity requestEntity : allRequestEntity) {

			RequestPojo requsetPojo = new RequestPojo(requestEntity.getReqId(), requestEntity.getUserId(),
					requestEntity.getReqType(), requestEntity.getReqAmount(), requestEntity.getSubmitDate().toString(),
					requestEntity.getApproveDate(), requestEntity.getManager(), requestEntity.getReqStatus());
			allRequestPojo.add(requsetPojo);
		}
		return allRequestPojo;
	}

}
