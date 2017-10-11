package com.iqmsoft.vertx.api.service;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

import java.util.List;

import com.iqmsoft.vertx.api.entity.Position;
import com.iqmsoft.vertx.api.repository.PositionDao;

/**
 * Created by tiago on 07/10/2017.
 */
public class PositionService {
    private PositionDao positionDao = PositionDao.getInstance();

    public void list(Handler<AsyncResult<List<Position>>> handler){
        Future<List<Position>> future = Future.future();
        future.setHandler(handler);

        try {
            List<Position> result = positionDao.findAll();
            future.complete(result);
        } catch (Throwable ex) {
            future.fail(ex);
        }
    }
}
