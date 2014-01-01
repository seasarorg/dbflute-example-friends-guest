/*
 [df:title]
 Example for Simple Select
 
 [df:description]
 This SQL is the most basic example for outsideSql.
 It uses CustomizeEntity and ParameterBean.
*/
-- #df:entity#

-- !df:pmb!
-- !!Integer memberId!! // this is parameter comment of MEMBER_ID
-- !!String memberName!! // this is parameter comment of MEMBER_NAME

select member.MEMBER_ID -- // this is select column comment of MEMBER_ID
     , member.MEMBER_NAME -- // this is select column comment of MEMBER_NAME
     , memberStatus.MEMBER_STATUS_NAME -- // this is joined table's column
  from MEMBER member
    left outer join MEMBER_STATUS memberStatus
      on member.MEMBER_STATUS_CODE = memberStatus.MEMBER_STATUS_CODE
 /*BEGIN*/where
   /*IF memberId != null*/member.MEMBER_ID = /*memberId*/3/*END*/
   /*IF memberName != null*/and member.MEMBER_NAME like /*memberName*/'S' || '%'/*END*/
 /*END*/
 order by member.MEMBER_ID asc
