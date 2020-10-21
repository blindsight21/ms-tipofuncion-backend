/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipofuncion.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.TipoFuncion;
import pe.gob.mimp.siscap.repository.tipofuncion.TipoFuncionRepository;
import pe.gob.mimp.tipofuncion.bean.FindByParamBean;
import pe.gob.mimp.tipofuncion.bean.TipoFuncionBean;
import pe.gob.mimp.tipofuncion.converter.TipoFuncionCast;
import pe.gob.mimp.tipofuncion.service.TipoFuncionService;
import pe.gob.mimp.tipofuncion.util.Util;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TipoFuncionServiceImpl implements TipoFuncionService {

    @Autowired
    private TipoFuncionRepository tipoFuncionRepository;

    @Override
    public void crearTipoFuncion(TipoFuncionBean tipoFuncionBean) throws Exception {

        TipoFuncion tipoFuncion = new TipoFuncion();
        tipoFuncion.setTxtTipoFuncion(tipoFuncionBean.getTxtTipoFuncion());
        tipoFuncion.setNidUsuario(tipoFuncionBean.getNidUsuario());
        tipoFuncion.setTxtPc(tipoFuncionBean.getTxtPc());
        tipoFuncion.setTxtIp(tipoFuncionBean.getTxtIp());
        tipoFuncion.setFecEdicion(tipoFuncionBean.getFecEdicion());
        tipoFuncion.setFlgActivo(tipoFuncionBean.getFlgActivo());

        tipoFuncionRepository.save(tipoFuncion);

    }

    @Override
    public void editarTipoFuncion(TipoFuncionBean tipoFuncionBean) {

        TipoFuncion tipoFuncion = new TipoFuncion();

        tipoFuncion.setNidTipoFuncion(tipoFuncionBean.getNidTipoFuncion());
        tipoFuncion.setTxtTipoFuncion(tipoFuncionBean.getTxtTipoFuncion());
        tipoFuncion.setNidUsuario(tipoFuncionBean.getNidUsuario());
        tipoFuncion.setTxtPc(tipoFuncionBean.getTxtPc());
        tipoFuncion.setTxtIp(tipoFuncionBean.getTxtIp());
        tipoFuncion.setFecEdicion(tipoFuncionBean.getFecEdicion());
        tipoFuncion.setFlgActivo(tipoFuncionBean.getFlgActivo());

        tipoFuncionRepository.save(tipoFuncion);

    }

    @Override
    public String obtenerTipoFuncionPorId(BigDecimal nidTipoFuncion) throws Exception {

        Optional<TipoFuncion> tipoFuncion = tipoFuncionRepository.findById(nidTipoFuncion);

        if (tipoFuncion.isPresent()) {
            return tipoFuncion.get().getTxtTipoFuncion();
        }

        return "";
    }

    @Override
    public List<TipoFuncionBean> loadTipoFuncionList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<TipoFuncion> tipoFuncionList = tipoFuncionRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(tipoFuncionList)) {

            return tipoFuncionList.stream().map(tipoFuncion -> {
                TipoFuncionBean tipoFuncionBean = new TipoFuncionBean();
                tipoFuncionBean.setNidTipoFuncion(tipoFuncion.getNidTipoFuncion());
                tipoFuncionBean.setTxtTipoFuncion(tipoFuncion.getTxtTipoFuncion());
                tipoFuncionBean.setNidUsuario(tipoFuncion.getNidUsuario());
                tipoFuncionBean.setTxtPc(tipoFuncion.getTxtPc());
                tipoFuncionBean.setTxtIp(tipoFuncion.getTxtIp());
                tipoFuncionBean.setFecEdicion(tipoFuncion.getFecEdicion());
                tipoFuncionBean.setFlgActivo(tipoFuncion.getFlgActivo());
                return tipoFuncionBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public TipoFuncionBean find(BigDecimal id) {

        Optional<TipoFuncion> tipoFuncion = tipoFuncionRepository.findById(id);

        if (!tipoFuncion.isPresent()) {
            return null;
        }

        return TipoFuncionCast.castTipoFuncionToTipoFuncionBean(tipoFuncion.get());

    }

}
