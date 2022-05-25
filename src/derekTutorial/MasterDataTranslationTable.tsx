import React from 'react';
import {
  TableContainer,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  TablePagination,
} from '@mui/material';
import Highlighter from 'react-highlight-words';
import { useSelector, useDispatch } from 'react-redux';

import { ReducersState } from '../../redux/rootReducer';
import ActionName from '../../constants/actionNames';

import OutlineInput from '../inputs/TranslationInput';
import { doTranslation } from '../../screens/Admin/ProductSettings/MasterDataTranslation/services';
import masterDataSelection from '../../constants/masterDataCodes';
import styles from './translationStyle';

function LocationOverviewTable({ listData, listName, resetTranslation }: any) {
  const classes = styles();
  const dispatch = useDispatch();
  const { isLoading } = useSelector((state: ReducersState) => state.GlobalReducer);

  /**
   * handle change of first language field
   */
  const {
    language1,
    language2,
    totalCount,
    page,
    limit,
    search,
    langCode1,
    langCode2,
    userName,
    languageId1,
    languageId2,
    languageId1Count,
    languageId2Count,
  } = useSelector((state: ReducersState) => state.MasterDataTranslationReducer);

  const dispatchNewData = (list: any) => {
    switch (listName) {
      case masterDataSelection.attentionPoints.index:
        dispatch({
          type: ActionName.MASTER_DATA_TRANSLATION,
          payload: {
            attentionPointsData: list,
          },
        });
        break;
      case masterDataSelection.locations.index:
        dispatch({
          type: ActionName.MASTER_DATA_TRANSLATION,
          payload: {
            locationsData: list,
          },
        });
        break;
      default:
    }
  };

  const handleLang1 = (event: any, id: any, index: any) => {
    const list = listData;
    list[index].nameLanguage1 = event.target.value;
    list[index].isLang1Trans = false;
    list[index].lang1TransBy = event.target.value ? userName : '';
    list[index].languageId1 = languageId1;
    dispatchNewData(list);
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        isChanged: true,
      },
    });
  };

  const handleLang2 = (event: any, id: any, index: any) => {
    const list = listData;
    list[index].nameLanguage2 = event.target.value;
    list[index].isLang2Trans = false;
    list[index].lang2TransBy = event.target.value ? userName : '';
    list[index].languageId2 = languageId2;
    dispatchNewData(list);
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        isChanged: true,
      },
    });
  };

  const translate = async (
    text: string,
    target: any,
    nameLanguage: any,
    index: any,
    isTrans: any,
    langTransBy: any,
    languageKey: any,
    languageId: any
  ) => {
    const list = listData;

    doTranslation(text, target, (translation: any) => {
      list[index][nameLanguage] = translation;
      list[index][isTrans] = true;
      list[index][langTransBy] = 'Google';
      list[index][languageKey] = languageId;
      dispatchNewData(list);
    });
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        isChanged: true,
      },
    });
  };

  const handleChangePage = (event: React.MouseEvent<HTMLButtonElement> | null, newPage: number) => {
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        page: newPage + 1,
      },
    });
    resetTranslation();
  };

  const handleChangeRowsPerPage = (
    event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    dispatch({
      type: ActionName.MASTER_DATA_TRANSLATION,
      payload: {
        limit: event.target.value,
        page: 1,
      },
    });
    resetTranslation();
  };

  const bayRowWithSorting = () =>
    listData?.map((bay: any, index: any) => (
      <TableRow className={classes.categoriesItems}>
        <TableCell style={{ paddingLeft: '3%' }}>
          <Highlighter
            highlightClassName="YourHighlightClass"
            searchWords={[search]}
            autoEscape
            textToHighlight={bay.name}
          />
        </TableCell>
        <TableCell align="left">
          <OutlineInput
            values={bay.nameLanguage2 ? bay.nameLanguage2 : ''}
            name="secondLanguage"
            onChange={(e: any) => handleLang2(e, bay.id, index)}
            translation
            variant="outlined"
            translationHandle={() =>
              translate(
                bay.name,
                langCode2,
                'nameLanguage2',
                index,
                'isLang2Trans',
                'lang2TransBy',
                'languageId2',
                languageId2
              )
            }
          />
        </TableCell>
        <TableCell align="left">{bay.lang1TransBy ? bay.lang1TransBy : '-'}</TableCell>
        <TableCell align="left">
          <OutlineInput
            values={bay.nameLanguage1 ? bay.nameLanguage1 : ''}
            onChange={(e: any) => handleLang1(e, bay.id, index)}
            name="firstTranslationName"
            translation
            variant="outlined"
            translationHandle={() =>
              translate(
                bay.name,
                langCode1,
                'nameLanguage1',
                index,
                'isLang1Trans',
                'lang1TransBy',
                'languageId1',
                languageId1
              )
            }
          />
        </TableCell>
        <TableCell align="left">{bay.lang2TransBy ? bay.lang2TransBy : '-'}</TableCell>
      </TableRow>
    ));

  return (
    <>
      <TableContainer className={classes.tableContainer}>
        <Table aria-label="simple table">
          <TableHead style={{ borderTop: '1px solid #e2dcdc' }}>
            <TableRow className={classes.categories}>
              <TableCell align="left">Source string in english</TableCell>
              <TableCell align="left">{language2 || '-'} </TableCell>
              <TableCell align="left">Translated by</TableCell>
              <TableCell align="left">{language1 || '-'} </TableCell>
              <TableCell align="left">Translated by</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {listData?.length ? (
              <>
                <TableRow className={classes.categoriesItemsRow}>
                  <TableCell>
                    {listName === masterDataSelection.attentionPoints.index
                      ? 'Attention Points'
                      : 'Locations'}{' '}
                  </TableCell>
                  <TableCell align="left">
                    {languageId2Count}/{totalCount}
                  </TableCell>
                  <TableCell align="left" />
                  <TableCell align="left">
                    {languageId1Count}/{totalCount}
                  </TableCell>
                  <TableCell align="left" />
                </TableRow>
                {bayRowWithSorting()}
              </>
            ) : (
              <TableRow className={classes.categories}>
                <TableCell align="center" colSpan={9}>
                  <div className={classes.noRecords}>{isLoading ? 'Loading' : 'No Records'}</div>
                </TableCell>
              </TableRow>
            )}
          </TableBody>
        </Table>
      </TableContainer>
      <div className={classes.paginationContainer}>
        <TablePagination
          component="div"
          count={totalCount}
          page={page - 1}
          onPageChange={handleChangePage}
          rowsPerPage={limit}
          labelDisplayedRows={({ from, to }) => `  ${from} - ${to} of  ${totalCount} `}
          onRowsPerPageChange={handleChangeRowsPerPage}
        />
      </div>
    </>
  );
}

export default LocationOverviewTable;