/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipofuncion.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.tipofuncion.bean.FindByParamBean;

import pe.gob.mimp.tipofuncion.bean.ResponseData;
import pe.gob.mimp.tipofuncion.bean.TipoFuncionBean;
import pe.gob.mimp.tipofuncion.service.TipoFuncionService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class TipoFuncionController {

    @Autowired
    private TipoFuncionService tipoFuncionService;

    @PostMapping(value = "/crearTipoFuncion", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearTipoFuncion(@RequestBody TipoFuncionBean tipoFuncionBean) throws Exception {

        tipoFuncionService.crearTipoFuncion(tipoFuncionBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarTipoFuncion", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarTipoFuncion(@RequestBody TipoFuncionBean tipoFuncionBean) throws Exception {

        tipoFuncionService.editarTipoFuncion(tipoFuncionBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerTipoFuncionPorId/{nidTipoFuncion}")
    public ResponseEntity<ResponseData<?>> obtenerTipoFuncionPorId(@PathVariable("nidTipoFuncion") BigDecimal nidTipoFuncion) throws Exception {

        String txtTipoFuncion = tipoFuncionService.obtenerTipoFuncionPorId(nidTipoFuncion);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtTipoFuncion);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadTipoFuncionList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadTipoFuncionList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<TipoFuncionBean> tipoFuncionList = tipoFuncionService.loadTipoFuncionList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoFuncionList);

        return ResponseEntity.ok(response);

    }
    
    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = tipoFuncionService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        TipoFuncionBean tipoFuncionBean = tipoFuncionService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoFuncionBean);

        return ResponseEntity.ok(response);

    }

}
