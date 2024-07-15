package com.onurerkantoros.simplebanking.dto;

public class TransactionResponseDto {
    private String status;
    private String approvalCode;

    public TransactionResponseDto() {
    }

    public TransactionResponseDto(String status, String approvalCode) {
        this.status = status;
        this.approvalCode = approvalCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
}
