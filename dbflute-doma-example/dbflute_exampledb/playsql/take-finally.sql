
-- =======================================================================================
--                                                                     Business Constraint
--                                                                     ===================
-- #df:assertCountZero#
-- /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
-- Formalized members should have their own formalized date-times.
-- - - - - - - - - - -/
select count(*)
  from MEMBER
 where MEMBER_STATUS_CODE = 'FML'
   and FORMALIZED_DATETIME is null
;

-- #df:assertListZero#
-- /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
-- Withdrawal members should have their own withdrawal informations.
-- - - - - - - - - - -/
select member.MEMBER_ID, member.MEMBER_NAME
  from MEMBER member
 where member.MEMBER_STATUS_CODE = 'WDL'
   and not exists (select withdrawal.MEMBER_ID
                     from MEMBER_WITHDRAWAL withdrawal
                    where withdrawal.MEMBER_ID = member.MEMBER_ID
       )
;

-- #df:assertListZero#
select member.MEMBER_ID as MEMBER_ID
     , count(member.MEMBER_ID) as SELECTED_COUNT
     , min(address.MEMBER_ADDRESS_ID) as MIN_ADDRESS_ID
     , max(address.MEMBER_ADDRESS_ID) as MAX_ADDRESS_ID
     , CURRENT_DATE as TARGET_DATE
  from MEMBER member
    left outer join MEMBER_ADDRESS address
      on member.MEMBER_ID = address.MEMBER_ID
     and address.VALID_BEGIN_DATE <= CURRENT_DATE
     and address.VALID_END_DATE >= CURRENT_DATE
 group by member.MEMBER_ID
   having count(member.MEMBER_ID) > 1 
;

-- =======================================================================================
--                                                                     TestData Constraint
--                                                                     ===================
-- /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
-- These tables should have at least one record at ut and should not have at real.
-- - - - - - - - - - -/
-- #df:assertCountExists@ut#
-- #df:assertCountZero@real#
select count(*) from MEMBER member
;
-- #df:assertCountExists@ut#
-- #df:assertCountZero@real#
select count(*) from MEMBER_LOGIN login
;
