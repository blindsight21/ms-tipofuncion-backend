/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipofuncion.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.tipofuncion.bean.FindByParamBean;
import pe.gob.mimp.tipofuncion.bean.TipoFuncionBean;

/**
 *
 * @author Omar
 */
public interface TipoFuncionService {

    void crearTipoFuncion(TipoFuncionBean tipoFuncionBean) throws Exception;

    void editarTipoFuncion(TipoFuncionBean tipoFuncionBean) throws Exception;

//    void anularTipoFuncion(TipoFuncionBean tipoFuncionBean) throws Exception;
    String obtenerTipoFuncionPorId(BigDecimal nidTipoFuncion) throws Exception;

    List<TipoFuncionBean> loadTipoFuncionList(FindByParamBean findByParamBean) throws Exception;

    TipoFuncionBean find(BigDecimal id);

}
