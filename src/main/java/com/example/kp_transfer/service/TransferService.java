package com.example.kp_transfer.service;

import com.example.kp_transfer.exceptions.InvalidDataException;
import com.example.kp_transfer.model.SchemaConfirm;
import com.example.kp_transfer.model.SchemaResponse;
import com.example.kp_transfer.model.Transfer;
import com.example.kp_transfer.repository.TransferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransferService {
    private final TransferRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(TransferService.class);


    public TransferService(TransferRepository repository) {
        this.repository = repository;
    }

    public SchemaResponse getTransfer(Transfer transfer) {
        checkValid(transfer);
        return repository.getTransfer(transfer);
    }

    public SchemaResponse confirmOperation(SchemaConfirm schemaConfirm) {
        if (schemaConfirm.getCode().equals("0000")) {
            return repository.confirmOperation(schemaConfirm);
        }
        throw new InvalidDataException("Invalid transfer: Invalid VerificationCode");
    }

    public void checkValid(Transfer transfer) {

        if (transfer.getCardFromNumber().length() != 16) {
            throw new InvalidDataException("Invalid transfer: Invalid CardFromNumber");
        }

        if (transfer.getCardToNumber().length() != 16) {
            throw new InvalidDataException("Invalid transfer: Invalid CardToNumber");
        }

        String[] validTill = transfer.getCardFromValidTill().split("/");
        try {
            if (Integer.parseInt(validTill[0]) > 12 || Integer.parseInt(validTill[0]) < 1) {
                throw new InvalidDataException("Invalid transfer: Invalid CardFromValidTill");
            }
            if (((LocalDate.now().getYear() % 100) == Integer.parseInt(validTill[1])) && (LocalDate.now().getMonthValue() < Integer.parseInt(validTill[0]))) {
                throw new InvalidDataException("Invalid transfer: Invalid CardFromValidTill");
            }
            if ((LocalDate.now().getYear() % 100) > Integer.parseInt(validTill[1])) {
                throw new InvalidDataException("Invalid transfer: Invalid CardFromValidTill");
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidDataException("Invalid transfer: Invalid CardFromValidTill");
        }

        if (transfer.getCardFromCVV().length() != 3) {
            throw new InvalidDataException("Invalid transfer: Invalid CardFromCVV");
        }

        if (transfer.getAmount().getValue() < 0) {
            throw new InvalidDataException("Invalid transfer: Invalid Value");
        }
    }
}














