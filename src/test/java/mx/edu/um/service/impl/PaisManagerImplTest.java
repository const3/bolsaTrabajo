package mx.edu.um.service.impl;

import java.util.ArrayList;
import java.util.List;

import mx.edu.um.dao.PaisDao;
import mx.edu.um.model.Pais;
import mx.edu.um.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class PaisManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private PaisManagerImpl manager;

    @Mock
    private PaisDao dao;


    @Test
    public void testGetPais() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final Pais pais = new Pais();
        given(dao.get(id)).willReturn(pais);

        //when
        Pais result = manager.get(id);

        //then
        assertSame(pais, result);
    }

    @Test
    public void testGetPaiss() {
        log.debug("testing getAll...");
        //given
        final List paiss = new ArrayList();
        given(dao.getAll()).willReturn(paiss);

        //when
        List result = manager.getAll();

        //then
        assertSame(paiss, result);
    }

    @Test
    public void testSavePais() {
        log.debug("testing save...");

        //given
        final Pais pais = new Pais();
        // enter all required fields
        pais.setNombre("HwEeUuOfXkYqBhReUqClToSgLgApXwMmZgRkUoDlLbCxHxFwPs");
        


        given(dao.save(pais)).willReturn(pais);

        //when
        manager.save(pais);

        //then
        verify(dao).save(pais);
    }

    @Test
    public void testRemovePais() {
        log.debug("testing remove...");

        //given
        final Long id = -11L;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}