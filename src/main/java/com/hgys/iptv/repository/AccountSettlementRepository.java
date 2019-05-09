package com.hgys.iptv.repository;

import com.hgys.iptv.model.AccountSettlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSettlementRepository extends JpaRepository<AccountSettlement,Object>, JpaSpecificationExecutor<AccountSettlement> {
}
