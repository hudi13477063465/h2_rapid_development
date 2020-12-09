DROP TABLE IF EXISTS t_subject;
CREATE TABLE t_subject
(
    sort             int(11)      DEFAULT NULL,-- COMMENT '题目序号',
    type             int(2)       DEFAULT NULL,-- COMMENT '题目类型',
    subject_content  varchar(800) DEFAULT NULL,-- COMMENT '题目内容',
    shared_question varchar(800) DEFAULT NULL,-- COMMENT '共享题干题',
    right_answer     varchar(20)  DEFAULT NULL,-- COMMENT '题目正确答案',
    id               int(11) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
create hash index if not exists subject_sort_idx ON t_subject (sort);
