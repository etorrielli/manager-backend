package com.trimix.manager.service;

import com.trimix.manager.dao.TipoDocumentoDao;
import com.trimix.manager.dto.Response;
import com.trimix.manager.exception.EntityNotFoundException;
import com.trimix.manager.model.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoDocumentoService {

    @Autowired
    private TipoDocumentoDao tipoDocumentoDao;

    public TipoDocumento get(int id) throws EntityNotFoundException, Exception {
        return tipoDocumentoDao.get(id);
    }

    public Response list() throws Exception {
        Response response = new Response();
        List<TipoDocumento> tipoDocumentos = tipoDocumentoDao.list();
        response.setData(tipoDocumentos);
        return response;
    }


}














