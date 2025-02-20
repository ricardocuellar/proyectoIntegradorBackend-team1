package com.petcare.backend.proyectoIntegrador.service.impl;

import com.petcare.backend.proyectoIntegrador.entity.DetallePedido;
import com.petcare.backend.proyectoIntegrador.repository.IDetallePedidoRepository;
import com.petcare.backend.proyectoIntegrador.service.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServiceImpl implements IDetallePedidoService {

    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;
    
    @Override
    public DetallePedido crear(DetallePedido detallePedido) {
        detallePedido.setFechaRegistro(LocalDateTime.now());
        detallePedido.setFechaActualizacion(LocalDateTime.now());
        detallePedido.setEsBorrado(false);
        return detallePedidoRepository.save(detallePedido);
    }
    
    @Override
    public Optional<DetallePedido> obtenerPorId(Short id) {
        return detallePedidoRepository.findById(id);
    }
    
    @Override
    public List<DetallePedido> listarTodos() {
        return detallePedidoRepository.findActivos();
    }
    
    @Override
    public List<DetallePedido> listarPorPedido(Short pedidoId) {
        return detallePedidoRepository.findByPedidoId(pedidoId);
    }
    
    @Override
    public List<DetallePedido> listarPorServicio(Short servicioId) {
        return detallePedidoRepository.findByServicioId(servicioId);
    }
    
    @Override
    public DetallePedido actualizar(DetallePedido detallePedido) {
        detallePedido.setFechaActualizacion(LocalDateTime.now());
        return detallePedidoRepository.save(detallePedido);
    }
    
    @Override
    public void eliminar(Short id) {
        Optional<DetallePedido> detallePedido = detallePedidoRepository.findById(id);
        if (detallePedido.isPresent()) {
            DetallePedido dp = detallePedido.get();
            dp.setEsBorrado(true);
            dp.setFechaBorrado(LocalDateTime.now());
            detallePedidoRepository.save(dp);
        }
    }
} 