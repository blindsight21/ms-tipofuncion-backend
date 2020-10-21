/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipofuncion.converter;

import pe.gob.mimp.siscap.model.TipoFuncion;
import pe.gob.mimp.tipofuncion.bean.TipoFuncionBean;

/**
 *
 * @author Omar
 */
public class TipoFuncionCast {

    public static TipoFuncionBean castTipoFuncionToTipoFuncionBean(TipoFuncion tipoFuncion) {

        if (tipoFuncion == null) {
            return null;
        }

        TipoFuncionBean tipoFuncionBean = new TipoFuncionBean();

        tipoFuncionBean.setNidTipoFuncion(tipoFuncion.getNidTipoFuncion());
        tipoFuncionBean.setTxtTipoFuncion(tipoFuncion.getTxtTipoFuncion());
        tipoFuncionBean.setFlgActivo(tipoFuncion.getFlgActivo());
        tipoFuncionBean.setNidUsuario(tipoFuncion.getNidUsuario());
        tipoFuncionBean.setTxtPc(tipoFuncion.getTxtPc());
        tipoFuncionBean.setTxtIp(tipoFuncion.getTxtIp());
        tipoFuncionBean.setFecEdicion(tipoFuncion.getFecEdicion());

        return tipoFuncionBean;
    }

    public static TipoFuncion castTipoFuncionBeanToTipoFuncion(TipoFuncionBean tipoFuncionBean) {

        if (tipoFuncionBean == null) {
            return null;
        }

        TipoFuncion tipoFuncion = new TipoFuncion();

        tipoFuncion.setNidTipoFuncion(tipoFuncionBean.getNidTipoFuncion());
        tipoFuncion.setTxtTipoFuncion(tipoFuncionBean.getTxtTipoFuncion());
        tipoFuncion.setFlgActivo(tipoFuncionBean.getFlgActivo());
        tipoFuncion.setNidUsuario(tipoFuncionBean.getNidUsuario());
        tipoFuncion.setTxtPc(tipoFuncionBean.getTxtPc());
        tipoFuncion.setTxtIp(tipoFuncionBean.getTxtIp());
        tipoFuncion.setFecEdicion(tipoFuncionBean.getFecEdicion());

        return tipoFuncion;
    }
}
