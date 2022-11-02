package br.com.exacta.models.enumerators;

import java.util.List;

public enum UserStatusEnum {

    ACTIVE("Ativo"), BLOCKED("Bloqueado"), CANCELED("Cancelado");

    private String status;

    UserStatusEnum(String status) {
        this.status = status;
    }

    public List<UserStatusEnum> list() {
        return List.of(UserStatusEnum.values());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
