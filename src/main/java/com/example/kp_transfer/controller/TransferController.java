package com.example.kp_transfer.controller;

import com.example.kp_transfer.model.SchemaConfirm;
import com.example.kp_transfer.model.SchemaResponse;
import com.example.kp_transfer.model.Transfer;
import com.example.kp_transfer.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    private final TransferService service;


    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public SchemaResponse getTransfer(@RequestBody Transfer transfer) {
        return service.getTransfer(transfer);
    }

    @PostMapping("/confirmOperation")
    public SchemaResponse confirmOperation(@RequestBody SchemaConfirm schemaConfirm){
        return service.confirmOperation(schemaConfirm);
    }

}
