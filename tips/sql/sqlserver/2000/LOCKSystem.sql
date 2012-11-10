-- Looks for Locked resources in SQL Server 2000
SELECT req_spid AS 'spid',
DB_NAME(rsc_dbid) AS 'Database',
OBJECT_NAME(rsc_objid) AS 'Name',
rsc_indid AS 'Index',
rsc_text AS 'Description',
ResourceType = CASE WHEN rsc_type = 1 THEN 'NULL Resource'
WHEN rsc_type = 2 THEN 'Database'
WHEN rsc_type = 3 THEN 'File'
WHEN rsc_type = 4 THEN 'Index'
WHEN rsc_type = 5 THEN 'Table'
WHEN rsc_type = 6 THEN 'Page'
WHEN rsc_type = 7 THEN 'Key'
WHEN rsc_type = 8 THEN 'Extent'
WHEN rsc_type = 9 THEN 'RID (Row ID)'
WHEN rsc_type = 10 THEN 'Application'
ELSE 'Unknown'
END,
Status = CASE WHEN req_status = 1 THEN 'Granted'
WHEN req_status = 2 THEN 'Converting'
WHEN req_status = 3 THEN 'Waiting'
ELSE 'Unknown'
END,
OwnerType =
CASE WHEN req_ownertype = 1 THEN 'Transaction'
WHEN req_ownertype = 2 THEN 'Cursor'
WHEN req_ownertype = 3 THEN 'Session'
WHEN req_ownertype = 4 THEN 'ExSession'
ELSE 'Unknown'
END,
LockRequestMode =
CASE WHEN req_mode = 0 THEN 'No access '
WHEN req_mode = 1 THEN 'Sch-S (Schema stability)'
WHEN req_mode = 2 THEN 'Sch-M (Schema modification)'
WHEN req_mode = 3 THEN 'S (Shared)'
WHEN req_mode = 4 THEN 'U (Update)'
WHEN req_mode = 5 THEN 'X (Exclusive)'
WHEN req_mode = 6 THEN 'IS (Intent Shared)'
WHEN req_mode = 7 THEN 'IU (Intent Update)'
WHEN req_mode = 8 THEN 'IX (Intent Exclusive)'
WHEN req_mode = 9 THEN 'SIU (Shared Intent Update)'
WHEN req_mode = 10 THEN 'SIX (Shared Intent Exclusive)'
WHEN req_mode = 11 THEN 'UIX (Update Intent Exclusive)'
WHEN req_mode = 12 THEN 'BU. (Bulk operations)'
WHEN req_mode = 13 THEN 'RangeS_S'
WHEN req_mode = 14 THEN 'RangeS_U'
WHEN req_mode = 15 THEN 'RangeI_N'
WHEN req_mode = 16 THEN 'RangeI_S'
WHEN req_mode = 17 THEN 'RangeI_U'
WHEN req_mode = 18 THEN 'RangeI_X'
WHEN req_mode = 19 THEN 'RangeX_S'
WHEN req_mode = 20 THEN 'RangeX_U'
WHEN req_mode = 21 THEN 'RangeX_X'
ELSE 'Unknown'
END
into #t1
FROM master.dbo.syslockinfo
GO

select distinct name from #t1 where ResourceType = 'Page' order by name