
comment on table MEMBER is '会員: 会員登録時にInsertされる。
物理削除されることはない';
comment on column MEMBER.MEMBER_ID is '会員ID: 連番';
comment on column MEMBER.MEMBER_NAME is '会員名称: 会員の表示用の名称(姓名)';
comment on column MEMBER.MEMBER_ACCOUNT is '会員アカウント: 会員のログイン用のアカウント';
comment on column MEMBER.MEMBER_STATUS_CODE is '会員ステータスコード: ';
comment on column MEMBER.BIRTHDATE is '生年月日: 不明な場合はデータなし';
comment on column MEMBER.FORMALIZED_DATETIME is '正式会員日時: 正式会員になる前はデータなし';
comment on table MEMBER_ADDRESS is '会員住所情報: 有効期間による履歴管理';
comment on column MEMBER_ADDRESS.MEMBER_ADDRESS_ID is '会員住所ID:';
comment on column MEMBER_ADDRESS.MEMBER_ID is '会員ID:';
comment on column MEMBER_ADDRESS.VALID_BEGIN_DATE is '有効開始日: 有効期間の開始日。前の終了日の一日後の値が格納される。';
comment on column MEMBER_ADDRESS.VALID_END_DATE is '有効終了日: 有効期間の終了日。次の有効開始日の一日前の値が格納される。';
comment on column MEMBER_ADDRESS.ADDRESS is '住所: 住所をまるごと';
comment on table MEMBER_STATUS is '会員ステータス: 固定の区分値';
comment on column MEMBER_STATUS.MEMBER_STATUS_CODE is '会員ステータスコード: ';
comment on column MEMBER_STATUS.MEMBER_STATUS_NAME is '会員ステータス名称: ';
comment on column MEMBER_STATUS.DISPLAY_ORDER is '表示順: 昇順で利用';
comment on table MEMBER_LOGIN is '会員ログイン: ログインの度にInsertされる';
comment on column MEMBER_LOGIN.MEMBER_LOGIN_ID is '会員ログインID: ';
comment on column MEMBER_LOGIN.MEMBER_ID is '会員ID: ';
comment on column MEMBER_LOGIN.LOGIN_DATETIME is 'ログイン日時: ';
comment on column MEMBER_LOGIN.MOBILE_LOGIN_FLG is 'モバイルログインフラグ: モバイルからのログインか否か';
comment on column MEMBER_LOGIN.LOGIN_MEMBER_STATUS_CODE is 'ログイン会員ステータスコード: ログイン時の会員ステータス';
comment on table MEMBER_WITHDRAWAL is '会員退会情報: 退会するとInsertされる';
comment on table PURCHASE is '購入: 購入の度ににInsertされる';
comment on table PRODUCT is '商品: ';
comment on table PRODUCT_STATUS is '商品ステータス: ';
